package strategy

abstract class Animal {

    protected abstract fun makeSound(): Unit
//    Change 1 : there r animals dont run
//    fun run(): Unit {
//        println("I am ${this.javaClass.simpleName} and i'm running")
//    }

//    Change 3:
    lateinit var move: Move

    fun performMove(){
        move.move()
    }
}

//Change 2 : made interface for subclasses can introduce how they move
interface Move {
    fun move()
}

class Run : Move {
    override fun move() {
        println("i'm running")
    }
}

class Fly : Move {
    override fun move() {
        println("i'm flying")
    }
}


class Dog : Animal() {
    public override fun makeSound() {
        println("woof")
    }
}

class Cat : Animal() {
    public override fun makeSound() {
        println("meow")
    }
}

// Change 1 : new subclass added, but birds does not run they fly
class Bird : Move, Animal() {
    public override fun makeSound() {
        println("tweet")
    }

    init {
        move = Fly()
    }

    // Change 2: implemented Move interface but this case Animal hard to know who the child implements interface
    override fun move() {
        TODO("Not yet implemented")
    }
}