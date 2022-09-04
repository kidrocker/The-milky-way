package ke.kiura.snasa.ui.imageList.adapter

import ke.kiura.snasa.data.models.Image

interface Callback {
    fun imageClicked(image: Image)
}