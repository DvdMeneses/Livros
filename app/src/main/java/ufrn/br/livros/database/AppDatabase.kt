package ufrn.br.livros.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ufrn.br.livros.model.Livro
import ufrn.br.livros.repository.LivroDao


@Database(entities = [Livro::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun livroDao(): LivroDao
}