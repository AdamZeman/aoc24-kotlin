import java.io.File

class Player(pair: Pair<Int, Int>) {
    var x = 0
    var y = 0
    var dirState = 0
    val dirs =  listOf(
        Pair(-1,0),
        Pair(0,1),
        Pair(1,0),
        Pair(0,-1)
    )
    var dir = dirs[dirState]

    init {
        this.x = pair.first
        this.y = pair.second
    }

    fun rotate(){
        dirState += 1
        dirState %= 4
        dir = dirs[dirState]
    }

    fun move(){
        x += dir.second
        y += dir.first
    }
}

fun findPlayer(M : List<List<String>>): Pair<Int, Int>{

    for (i in 0 until M.size){
        for (j in 0 until M[i].size){
            if (M[i][j] == "^"){
                return Pair(j,i)
            }
        }
    }
    return Pair(0, 0)
}

fun inside(M : List<List<String>>, player: Pair<Int, Int>) : Boolean{
    val W = M[0].size
    val H = M.size

    if (player.first >= 0 && player.first < W && player.second >= 0 && player.second < H){
        return true
    }
    return false
}

fun sixthA() : Int{
    val filePath = "src/files/6.txt"
    val content = File(filePath).readText()
    val rows = content.split("\r\n")
    var setofPairs =  mutableSetOf<Pair<Int, Int>>()

    var M = rows.map{
        it.split("")
    }

    val p = Player(findPlayer(M))
    var time = 0
    while (
        inside(M, Pair(p.x, p.y) )
    ){
        if (time >= 10000){
            println("exceed")
            break
        }
        time+=1
        setofPairs.add(Pair(p.x, p.y))

        val tempCol = p.x + p.dir.second
        val tempRow = p.y + p.dir.first

        if (inside(M, Pair(tempCol, tempRow))){

        }else{
            break
        }
        if (M[tempRow][tempCol] == "#"){
            p.rotate()
        }else{
            p.move()
        }
    }
    println(setofPairs.size)

    return 0
}

fun isLooping(M : List<List<String>>, p: Player) : Boolean{
    var setOfPairs =  mutableSetOf<Pair<Int, Int>>()
    var time = 0

    while (
        inside(M, Pair(p.x, p.y) )
    ){
        if (time >= 10000){
            return true
        }
        time+=1
        setOfPairs.add(Pair(p.x, p.y))

        val tempCol = p.x + p.dir.second
        val tempRow = p.y + p.dir.first

        if (inside(M, Pair(tempCol, tempRow))){
        }else{
            break
        }
        if (M[tempRow][tempCol] == "#"){
            p.rotate()
        }else{
            p.move()
        }
    }

    return false
}

fun sixthB() : Int{
    val filePath = "src/files/6.txt"
    val content = File(filePath).readText()
    val rows = content.split("\r\n")
    val M = rows.map{
        it.split("")
    }
    val p = Player(findPlayer(M))
    var count = 0
    var all = 0

    for (i in 0 until M.size){
        for (j in 0 until M[i].size){
            val p = Player(findPlayer(M))
            all+=1
            val newM = M.map { it.toMutableList() }
            newM[i][j] = "#"
            if (isLooping(newM, p)){
                count++
            }
        }
    }

    println(count)
    return 0
}