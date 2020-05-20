package com.giftofhappiness.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.giftofhappiness.swoosh.Model.Player
import com.giftofhappiness.swoosh.R
import com.giftofhappiness.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class SkillActivity : BaseActivity() {


    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
    }


    fun onBallerClick(view: View ){
        beginnerSkillButton.isChecked = false
        player.skill = "baller"

    }

    fun onBeginnerClick(view:View){
        ballerSkillButton.isChecked = false
        player.skill = "beginner"

    }


    fun onSkillFinishClick(view: View) {
       if(player.skill != ""){
           val finishActivity = Intent(this, FinishActivity::class.java)
           finishActivity.putExtra(EXTRA_PLAYER, player)

           startActivity(finishActivity)
       }else{
           Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
       }

    }


}
