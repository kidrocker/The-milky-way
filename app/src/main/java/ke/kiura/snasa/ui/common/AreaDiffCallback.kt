package ke.kiura.snasa.ui.common

import androidx.recyclerview.widget.DiffUtil

import ke.kiura.snasa.data.models.Image;

/**
 * Class compares existing and new lists allowing adapters to refresh faster
 * This is more important when you are loading large amounts of data into a list.
 */

class ImageDiffCallback(
    private val newImages:List<Image>,
    private val oldImages: List<Image>
) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldImages.size
    }

    override fun getNewListSize(): Int {
        return newImages.size
    }

    /**
     * method leverages on the equals override on the data class
     */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldImages[oldItemPosition].url == newImages[newItemPosition].url
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldImages[oldItemPosition] == newImages[newItemPosition]
    }
}