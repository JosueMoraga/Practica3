//Principios Solid
/*
1. Single responsability(SRP)-Principio de Responsabilidad Unica
*/

//Ejemplo de no uso de SRP

/*
class factura (val items: List<Item>){
    fun calcularTotal(): Duble{
        return items.sumOf {it.precio}
    }
    fun generarReporte(): String{
        return "Reporte de la factura"
    }
}
*/

//
class Factura (){
    fun calcularTotal(): String{
        return "Este es el total"
    }
}

class ReporteFactura{
    fun generar(factura: Factura): String{
        return "Reporte de la factura"
    }
}

/*
2.Open/Clodes Principle (OCP) - Principio Abierto/Cerrado
 */

open class Empleado(val nombre: String, val horasTrabajadas: Int, val preciHora: Double ){
    open fun calcularSalario(): Double{
        return horasTrabajadas*preciHora
    }
} 

class EmpleadoConBono (nombre: String, horasTrabajadas: Int, preciHora: Double, val bono: Double): Empleado(nombre, horasTrabajadas, preciHora){
    override fun calcularSalario(): Double{
        return super.calcularSalario() + bono
    }
}

/*
3. Liskov Substitution Principle (LSP) - Pricipio de sustitucion de Liskov
*/

fun main (args: Array<String>){
    fun imprimirSalario(empleado: Empleado){
        println("El salario de ${empleado.nombre} es de ${empleado.calcularSalario()}")
    }

    val empleado = Empleado("Daniel", 40, 12.0)
    val empleadoConBono = EmpleadoConBono ("Fernanda", 40, 12.0, 70.0)

    imprimirSalario(empleado)
    imprimirSalario(empleadoConBono)
}

/*
4. Interface Segregation Principle (ISP) - Principio de Segregacion de Interfaces
*/

interface Trabajador{
    fun trabajar()
}

interface Asistente{
    fun asistir()
}

interface Reportero{
    fun generarReporte()
}

interface Programador: Trabajador{
    override fun trabajar(){
        println ("El programador esta programando")
    }
}

interface Albanil: Trabajador{
    override fun trabajar(){
        //Agregrar de trabajo
    }
}

/*
5.Dependecy inversion Principle (DIP) - Principio de Inversion de Dependecias
*/

interface Notificaciones {
    fun enviarNotificacion (Mensaje: String)
}

interface ServicioEmacil:Notificaciones {
    override fun enviarNotificacion (Mensaje: String){
        println("Enviando Email: $mensaje")
    }
}

interface Notificacion(val servicio:Notificaciones){
    fun enviarNotificacion(){
        servicio.enviarNotificacion("Notificacion Importante")
    }
}
