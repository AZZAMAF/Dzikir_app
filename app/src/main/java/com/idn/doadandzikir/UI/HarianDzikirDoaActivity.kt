package com.idn.doadandzikir.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikir.Adapter.DoadanDzikirAdapter
import com.idn.doadandzikir.Model.DoadanDzikirItem
import com.idn.doadandzikir.R
import com.idn.doadandzikir.databinding.ActivityHarianDzikirDoaBinding

class HarianDzikirDoaActivity : AppCompatActivity() {
    private var _binding: ActivityHarianDzikirDoaBinding? = null
    private val binding get() = _binding as ActivityHarianDzikirDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityHarianDzikirDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        providingDzikirData()
        initView()

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() {
        val mAdapter = DoadanDzikirAdapter()
        mAdapter.setData(providingDzikirData())
        binding.rvDoaHarian.adapter = mAdapter
        binding.rvDoaHarian.layoutManager = LinearLayoutManager(this)

    }

    private fun providingDzikirData(): List<DoadanDzikirItem> {
        val TitleDoa = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val ArabicDoa = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val TranselateDoa = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DoadanDzikirItem>()
        for (i in TitleDoa.indices) {
            val data = DoadanDzikirItem(
                TitleDoa[i],
                ArabicDoa[i],
                TranselateDoa[i]
            )
            listData.add(data)
        }

        return listData

    }

}