package main.kotlin

import java.lang.Math.abs

fun main(args : Array<String>)
{
    val t = readLine()?.toInt() ?: 0
    
    repeat(t){
    
        val config = readLine()!!.split(" ").map { it.toInt() }
        val x = readLine()!!.split( " ").map { it.toInt() }

        val a = config[1] -1
        val b = config[2] -1
        val c = config[3] -1
        val d = config[4] -1

        val x_a = x[a]
        val x_b = x[b]
        val x_c = x[c]
        val x_d = x[d]
        
        val p = config[5]
        val q = config[6]
        val y = config[7]


        val walk_ab = abs(x_a - x_b) *p
        var result = walk_ab

        val walk_ac = abs(x_a - x_c) * p
        val wait_c = y - walk_ac
        
        if(wait_c >= 0)
        {
            val drive_cd = abs(x_c-x_d)*q
            val walk_db = abs(x_d-x_b)*p

            val withTrain = walk_ac+wait_c+drive_cd+walk_db
        
            if(withTrain < walk_ab)
                result = withTrain
        }
        
        println(result)
    }
}
