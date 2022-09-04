package ke.kiura.snasa.ui.imageList.adapter

import androidx.recyclerview.widget.RecyclerView
import ke.kiura.snasa.data.models.Image
import ke.kiura.snasa.databinding.ImageListItemBinding

class ImageViewHolder(
    private val binding: ImageListItemBinding,
    private val callback: Callback
):RecyclerView.ViewHolder(binding.root) {
    fun bind(image: Image){
        binding.images = image
        binding.root.setOnClickListener {
            callback.imageClicked(image)
        }
    }
}