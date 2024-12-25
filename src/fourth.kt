import java.io.File

fun fourthA() : Int{

    fun inside(row:Int, col:Int, W:Int, H:Int): Boolean{
        return row >= 0 && row < H && col >= 0 && col < W
    }

    val filePath = "src/files/4.txt"
    var content = File(filePath).readText()
    val M = content.split("\n").filter { it.trim().isNotEmpty() }
    var out = 0


    val TEMP = "XMAS"

    for (row in 0 until M.size) {
        for (col in 0 until M[row].length) {

            if (M[row][col] == 'X'){
                for (drow in -1 until 2){
                    for (dcol in -1 until 2){
                        if (drow == 0 && dcol == 0){
                            continue
                        }
                        var all_ok = true
                        for (i in 0 until 4){
                            val rowIterative = row + drow * i
                            val colIterative = col + dcol * i

                            val width = M[0].length
                            val height = M.size

                            if (inside(rowIterative, colIterative, width, height) && TEMP[i] == M[rowIterative][colIterative]){
                            }else{
                                all_ok = false
                                break
                            }
                        }
                        if (all_ok){
                            out += 1
                        }
                    }
                }
            }
        }
    }

    return out
}

fun fourthB() : Int{

    fun inside(row:Int, col:Int, W:Int, H:Int): Boolean{
        return row >= 0 && row < H && col >= 0 && col < W
    }

    val filePath = "src/files/4.txt"
    var content = File(filePath).readText()
    val M = content.split("\n").filter { it.trim().isNotEmpty() }
    var out = 0

    var deltas = listOf(
        -1 to -1,
        -1 to 1,
        1 to 1,
        1 to -1,
        )

    val TEMP = "MMSS"

    for (row in 0 until M.size) {
        for (col in 0 until M[row].length) {

            if (M[row][col] == 'A'){

                var text = ""
                for (delta in deltas){
                    var row2 = row + delta.first
                    var col2 = col + delta.second

                    if(inside(row2, col2, M[row].length, M.size )){
                        text+= M[row2][col2]
                    }
                }
                if (text.length == 4){
                    for (i in 0 until 4){
                        val left = text.substring(0,i)
                        val right = text.substring(i,4)
                        val composed = right + left
                        if (composed == TEMP){
                            out++
                            break
                        }
                    }
                }
            }
        }
    }
    return out
}





