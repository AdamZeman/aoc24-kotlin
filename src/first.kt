import java.io.File

fun firstA() : Int{
    val filePath = "src/files/1.txt"
    val content = File(filePath).readText()

    val rows = content.split("\n").filter { it.trim().isNotEmpty() }

    val splittedRows = rows.mapNotNull { line ->
        val parts = line.trim().split(" ").filter { it.isNotBlank() }
        if (parts.size >= 2) {
            parts[0].toInt() to parts[1].toInt()
        }else{
            null
        }
    }

    val first = splittedRows.map { it.first }.sorted()
    val second = splittedRows.map { it.second }.sorted()

    var counter = 0
    for (i in first.indices) {
        counter += Math.abs(first[i] - second[i])
    }

    return counter
}

fun firstB() : Int{
    val filePath = "src/files/1.txt"
    val content = File(filePath).readText()

    val rows = content.split("\n").filter { it.trim().isNotEmpty() }

    val splittedRows = rows.mapNotNull { line ->
        val parts = line.trim().split(" ").filter { it.isNotBlank() }
        if (parts.size >= 2) {
            parts[0].toInt() to parts[1].toInt()
        }else{
            null
        }
    }

    val first = splittedRows.map { it.first }
    val second = splittedRows.map { it.second }

    val similarity = first.map{ fistvalue ->
        val numOfOcc = second.filter { secondValue -> secondValue == fistvalue }.count()
        numOfOcc * fistvalue
    }.sum()

    return similarity
}