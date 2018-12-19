package com.aaron.demo.fresco

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.aaron.demo.common.base.activity.appbar.AppBarActivity
import com.aaron.demo.common.base.widget.recycleview.RecyclerItemDecoration
import com.aaron.demo.common.manager.ARouterManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.aaron.demo.fresco.adapter.FrescoRecyclerAdapter
import kotlinx.android.synthetic.main.activity_fresco.*

/**
 * Created on 16/8/18.
 *
 * @author aaron.huang
 * @version 1.0.0
 */
@Route(path = ARouterManager.ROUTER_PATH_FRESCO)
class FrescoActivity : AppBarActivity() {
    private val imageCount = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fresco)
        initViews()
        title = "Fresco"
    }

    private fun initViews() {
        val layoutManager = LinearLayoutManager(this)
        frescoRecyclerView.layoutManager = layoutManager
        frescoRecyclerView.addItemDecoration(RecyclerItemDecoration(this,
                LinearLayoutManager.VERTICAL, R.drawable.main_recycler_divider))
        val frescoRecyclerAdapter = FrescoRecyclerAdapter(this)
        val list = mutableListOf<String>()
        //        list.add(R.drawable.beach_huts); //加载网络图片资源地址
        for (i in 0 until imageCount) {
            list.add("http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/06/ChMkJ1bKyqKIPFxLAGZe49gDZ3YAALIegJkT54AZl77897.jpg") //加载网络图片资源地址
        }
        list.add("http://img1.gamersky.com/image2014/06/20140608lk_4/2.gif") //加载网络gif动图地址
        frescoRecyclerView.adapter = frescoRecyclerAdapter
        frescoRecyclerAdapter.setData(list)
    }

}
