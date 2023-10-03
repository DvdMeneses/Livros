package ufrn.br.livros.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ufrn.br.livros.model.Livro


@Dao
interface LivroDao {

    @Insert
    fun inserir(livro: Livro)


    @Query("SELECT * FROM Livro")
    fun listar():List<Livro>
}