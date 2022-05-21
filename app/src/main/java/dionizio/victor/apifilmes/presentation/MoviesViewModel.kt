package dionizio.victor.apifilmes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dionizio.victor.apifilmes.data.model.ResultsModel
import dionizio.victor.apifilmes.data.repository.MovieRepository

class MoviesViewModel: ViewModel() {
    private val movieRepository = MovieRepository()
    private val mMovieList = MutableLiveData<ResultsModel>()
    val movieList : LiveData<ResultsModel> = mMovieList

    fun listMovies(){
        return movieRepository.listMovies()
    }
}