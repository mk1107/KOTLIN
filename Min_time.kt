/*
There are N cities in in a straight line numbered 1 to N. City i is located at coordinate xi on the x-axis. Guru wants to travel from city A to city B. He starts at time t=0. He has following choices to travel.

  1. He can walk 1 metre in P secs.
  2. There is a train that travels from city C to city D which travels 1 metre in Q secs which 
       starts at time t=Y secs. Guru can take the train only at city C and leave the train only at 
        city D.

I am helping Guru find the minimum time he will need to travel from city A to B. Note that you cannot board the train after time t =Y.

Input:
First line will contain T, number of test cases. Then the test cases follow.
First line of each test case contains eight space separated integers N,A,B,C,D,P,Q,Y.
Second line of each test case contains N space-separated integers with the i-th integer representing xi.

Output:
For each test case, output in a single line containing the minimum travel time.
*/

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
