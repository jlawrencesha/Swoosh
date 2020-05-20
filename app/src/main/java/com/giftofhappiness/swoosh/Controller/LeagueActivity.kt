package com.giftofhappiness.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.giftofhappiness.swoosh.Model.Player
import com.giftofhappiness.swoosh.R
import com.giftofhappiness.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

   // var selectedLeague = ""
    var player = Player("", "")



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }



    fun onMensClick(view: View){
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked =false

        player.league = "mens"

    }
    fun onWomensClick(view: View){
        mensLeagueBtn.isChecked=false
        coedLeagueBtn.isChecked = false

        player.league = "womens"

    }
    fun onCoedClick(view: View){
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false

        player.league = "co-ed"
    }

    fun leagueNextClicked(view: View){

        if(player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        }else{
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }



    }
}
