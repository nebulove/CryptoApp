package com.demo.cryptoappnew.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.demo.cryptoappnew.R
import com.demo.cryptoappnew.presentation.apapters.CoinInfoAdapter
import com.demo.cryptoappnew.data.model.CoinPriceInfo
import kotlinx.android.synthetic.main.activity_coin_price_list.*


class CoinPriceLIstActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                val intent = CoinDetailActivity.newIntent(
                    this@CoinPriceLIstActivity,
                    coinPriceInfo.fromsymbol
                )
                startActivity(intent)
            }

        }
        rvCoinPriceList.adapter = adapter
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.priceList.observe(this, Observer {
            adapter.coinInfoList = it
        })
    }


}





