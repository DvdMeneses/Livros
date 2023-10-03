package ufrn.br.livros
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ufrn.br.livros.databinding.ActivityCadastrarLivroBinding
import androidx.room.Room
import ufrn.br.livros.database.AppDatabase
import ufrn.br.livros.model.Livro

class CadastrarLivro : AppCompatActivity() {

    lateinit var binding : ActivityCadastrarLivroBinding
    var titulo:String=""
    var autor:String = ""
    var ano:Int = 0
    var nota:Float =0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_cadastrar_livro)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "livros.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()



        binding.buttonCadastrarLivro.setOnClickListener{

            titulo  = binding.editTextTextTitulo.text.toString()
            autor   = binding.editTextTextAutor.text.toString()
            ano     =   Integer.parseInt(binding.editTextTextAno.text.toString())
            nota    = binding.ratingBar.rating

            var livro:Livro = Livro(titulo,autor,ano,nota)
            db.livroDao().inserir(livro)
            finish()

        }

        binding.buttonCancelar.setOnClickListener{
            finish()
        }


    }
}


