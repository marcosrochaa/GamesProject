import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.turnIntoAge() : Int{
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var idade =  0
    val dataNascimento = LocalDate.parse(this, formatter)
    val today = LocalDate.now()
    idade = Period.between(dataNascimento, today).years

    return idade

}