package ufrn.br.livros

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import ufrn.br.livros.database.AppDatabase
import ufrn.br.livros.databinding.ActivityListarLivrosBinding
import ufrn.br.livros.model.Livro
import kotlin.math.log

class ListarLivros : AppCompatActivity() {
    lateinit var binding : ActivityListarLivrosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_listar_livros)


        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "livros.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()

        var ListaLivros:List<Livro> = db.livroDao().listar()

        if(ListaLivros.size>0){
            var LivroDaVez = 0

            binding.textViewTituloListar.text = ListaLivros[LivroDaVez].titulo
            binding.textViewAutorListar.text = ListaLivros[LivroDaVez].autor
            binding.textViewAnoListar.text = ListaLivros[LivroDaVez].ano.toString()
            binding.textViewNotaListar.text = ListaLivros[LivroDaVez].nota.toString()

            binding.buttonProximoListar.setOnClickListener{
                if(LivroDaVez+1 < ListaLivros.size){
                    LivroDaVez += 1
                    Log.i("ENTREI","entreiaaaa")
                    Log.i("VALOR DA VEZ","${ListaLivros[LivroDaVez].nota}")
                    binding.textViewTituloListar.text = ListaLivros[LivroDaVez].titulo
                    binding.textViewAutorListar.text = ListaLivros[LivroDaVez].autor
                    binding.textViewAnoListar.text = ListaLivros[LivroDaVez].ano.toString()
                    binding.textViewNotaListar.text = ListaLivros[LivroDaVez].nota.toString()

                }else{
                    Toast.makeText(this, "Esse é o ultimo Livro!", Toast.LENGTH_SHORT).show()
                }
            }
            binding.buttonAnteriorListar.setOnClickListener{
                if(LivroDaVez-1 >= 0){
                    LivroDaVez -= 1
                    binding.textViewTituloListar.text = ListaLivros[LivroDaVez].titulo
                    binding.textViewAutorListar.text = ListaLivros[LivroDaVez].autor
                    binding.textViewAnoListar.text = ListaLivros[LivroDaVez].ano.toString()
                    binding.textViewNotaListar.text = ListaLivros[LivroDaVez].nota.toString()

                }else{
                    Toast.makeText(this, "Esse é o primeiro Livro!", Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            Toast.makeText(this, "NEM UM LIVRO CADASTRADO", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}