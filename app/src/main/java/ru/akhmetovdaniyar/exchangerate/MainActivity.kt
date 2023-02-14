package ru.akhmetovdaniyar.exchangerate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var viewModel: ViewModelActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MainFragment>(R.id.fragmentContainerView)
            }
        }
        viewModel = ViewModelProvider(this)[ViewModelActivity::class.java]
    }
}