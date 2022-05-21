package dionizio.victor.apifilmes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import dionizio.victor.apifilmes.R
import dionizio.victor.apifilmes.presentation.MoviesViewModel

class MainActivity : AppCompatActivity() {
    val viewModel = MoviesViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.listMovies()
    }

}