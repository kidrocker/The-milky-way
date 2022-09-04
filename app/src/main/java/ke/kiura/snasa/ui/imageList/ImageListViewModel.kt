package ke.kiura.snasa.ui.imageList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ke.kiura.snasa.data.models.Image
import ke.kiura.snasa.network.Resource
import ke.kiura.snasa.repo.ListRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    private val repo: ListRepo
) : ViewModel() {
    private val _images: MutableLiveData<Resource<List<Image>>> = MutableLiveData()
    val images get() = _images
    var page: Int? = null

    init {
        // simulate a search value
        loadImages(page)
    }

    fun loadImages(page: Int?) {
        viewModelScope.launch {
            repo.searchImage(
                query = "milky way",
                mediaType = "image",
                start = "2017",
                end = "2017",
                page = page
            ).collect { value ->
                _images.value = value
            }
        }
    }
}