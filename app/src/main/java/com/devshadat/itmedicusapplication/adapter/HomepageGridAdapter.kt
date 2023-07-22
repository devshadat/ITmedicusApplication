import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import com.devshadat.itmedicusapplication.ProductActivity
import com.devshadat.itmedicusapplication.R
import com.devshadat.itmedicusapplication.entity.HomepageItem
import java.util.*
import kotlin.collections.ArrayList

class HomepageGridAdapter(context: Context, courseModelArrayList: ArrayList<HomepageItem>) :
    ArrayAdapter<HomepageItem?>(context, 0, courseModelArrayList as List<HomepageItem?>) {

    var rand: Random = Random()

    @SuppressLint("ResourceAsColor")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listitemView = convertView
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false)
        }

        val cardView: CardView =
            listitemView!!.findViewById(com.devshadat.itmedicusapplication.R.id.cardView)
        when (position) {
            0 -> cardView!!.setBackgroundColor(Color.rgb(98, 206, 249)) // sky
            1 -> cardView!!.setBackgroundColor(Color.rgb(66, 184, 124)) // green
            2 -> cardView!!.setBackgroundColor(Color.rgb(162, 142, 236)) // purple
            3 -> cardView!!.setBackgroundColor(Color.rgb(255, 112, 112)) // red
            4 -> cardView!!.setBackgroundColor(Color.rgb(236, 172, 74)) // orange
            5 -> cardView!!.setBackgroundColor(Color.rgb(251, 128, 186)) // pink
            6 -> cardView!!.setBackgroundColor(Color.rgb(98, 206, 249)) // sky
            7 -> cardView!!.setBackgroundColor(Color.rgb(66, 184, 124)) // green
            8 -> cardView!!.setBackgroundColor(Color.rgb(162, 142, 236)) //purple
        }


        /* val red = rand.nextInt(200 - 1)
         val green = rand.nextInt(200 - 1)
         val blue = rand.nextInt(200 - 1)
         cardView.setBackgroundColor(Color.rgb(red, green, blue))*/

        val homepageItem: HomepageItem? = getItem(position)
        val homepageItemTV = listitemView!!.findViewById<TextView>(R.id.idTVCourse)
        val homepageItemIV = listitemView.findViewById<ImageView>(R.id.idIVcourse)

        homepageItem?.itemName?.let {
            homepageItemTV.setText(it)
        }
        homepageItem?.itemImg?.let { homepageItemIV.setImageResource(it) }
        return listitemView
    }
}
