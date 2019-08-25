package chapter3.exercises

import chapter3.Branch
import chapter3.Leaf
import chapter3.Tree
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

// tag::init[]
fun <A, B> fold(ta: Tree<A>, l: (A) -> B, b: (B, B) -> B): B = TODO()

fun <A> sizeF(ta: Tree<A>): Int = TODO()

fun maximumF(ta: Tree<Int>): Int = TODO()

fun <A> depthF(ta: Tree<A>): Int = TODO()

fun <A, B> mapF(ta: Tree<A>, f: (A) -> B): Tree<B> = TODO()
// end::init[]

class Exercise_3_28 : WordSpec({
    "tree fold" should {

        val tree = Branch( //0
                Branch(Leaf(1), Leaf(2)), //2
                Branch(Leaf(3), //2
                        Branch(Branch(Leaf(4), Leaf(5)), //4
                                Branch(Leaf(21), //4
                                        Branch(Leaf(7), Leaf(8)))))) //5
        "!generalise size" {
            chapter3.solutions.sizeF(tree) shouldBe 15
        }

        "!generalise maximum" {
            chapter3.solutions.maximumF(tree) shouldBe 21
        }

        "!generalise depth" {
            chapter3.solutions.depthF(tree) shouldBe 5
        }

        "!generalise map" {
            chapter3.solutions.mapF(tree) { it * 10 } shouldBe
                    Branch( //0
                            Branch(Leaf(10), Leaf(20)), //2
                            Branch(Leaf(30), //2
                                    Branch(Branch(Leaf(40), Leaf(50)), //4
                                            Branch(Leaf(210), //4
                                                    Branch(Leaf(70), Leaf(80))))))
        }
    }
})