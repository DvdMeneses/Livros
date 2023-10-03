package ufrn.br.livros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ufrn.br.livros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        binding.buttonCadastrar.setOnClickListener{
            val i = Intent(this, CadastrarLivro::class.java)
            startActivity(i)
        }

        binding.buttonListar.setOnClickListener{
            val i = Intent(this, ListarLivros::class.java)
            startActivity(i)
        }




    }
}