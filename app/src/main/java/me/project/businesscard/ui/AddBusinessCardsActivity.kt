package me.project.businesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import me.project.businesscard.App
import me.project.businesscard.R
import me.project.businesscard.data.BusinessCard
import me.project.businesscard.databinding.ActivityAddBusinessCardsBinding

class AddBusinessCardsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardsBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {

       binding.colorSeekBar.setOnColorChangeListener { progress, color ->
           binding.textView.setTextColor(color)

       }





        binding.buttonConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                bgPersonalizado = binding.colorSeekBar.getColor().toString()

            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.buttonClose.setOnClickListener {
            finish()
        }
    }
}