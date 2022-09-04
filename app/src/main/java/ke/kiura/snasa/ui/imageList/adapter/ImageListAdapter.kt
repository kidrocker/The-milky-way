package ke.kiura.snasa.ui.imageList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ke.kiura.snasa.data.models.Image
import ke.kiura.snasa.databinding.ImageListItemBinding
import ke.kiura.snasa.ui.common.ImageDiffCallback

class ImageListAdapter(private val callback: Callback) :
    RecyclerView.Adapter<ImageViewHolder>() {
    private val images = mutableListOf<Image>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ImageViewHolder(
        ImageListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        callback
    )

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount() = images.size

    fun updateItems(list: List<Image>) {
          val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(ImageDiffCallback(list, images))
        images.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }
}