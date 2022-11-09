open class Tree(info_branch_amount: Int) {

    var amountOfBranches: Int = 0
        set(value) {
            if (value < 0) {
                println("Invalid amount of branches.")
            } else {
                field = value
            }
        }
        get() {
            if (field < 0) {
                return 0
            }
            return field
        }

    var amountOfLeaves: Int = 0
        set(value) {
            if (this.amountOfBranches == 0) {
                println("How can there be leaves on a tree without branches?")
            }
            else if (value < 0) {
                println("Invalid amount of leaves.")
            } else {
                field = value
            }
        }
        get() {
            if (field < 0) {
                return 0
            }
            return field
        }

    init {
        this.amountOfBranches = info_branch_amount
    }
    constructor () : this(0)

    constructor (info_branch_amount: Int, info_leaf_amount: Int) : this(info_branch_amount) {
        this.amountOfLeaves = info_leaf_amount
    }


    open fun getLeavesPerBranchRatio(): Float {
        if (this.amountOfBranches == 0) {
            return 0.0F
        }
        return this.amountOfLeaves * 1.0F / this.amountOfBranches
    }

    open fun setAmountOfLeavesViaRatio(ratio: Float) {
        this.amountOfLeaves = (this.amountOfBranches * ratio).toInt()
    }
}


open class BerryTree: Tree {
    var berry: String = "Undefined"
        set(value) {
            if (value == "Cherry" || value == "Pear" || value == "Apple") {
                field = value
            } else {
                println("Unknown berry type.")
            }
        }
        get() {
            return field
        }

    var amountOfBerries: Int = 0
        set(value) {
            if (this.amountOfBranches == 0) {
                println("How can there be berries on a tree without branches?")
            }
            else if (value < 0) {
                println("Invalid amount of berries.")
            } else {
                field = value
            }
        }
        get() {
            return field
        }

    constructor (info_branch_amount: Int, info_leaf_amount: Int, info_berry_type: String) : super(info_branch_amount, info_leaf_amount) {
        this.berry = info_berry_type
    }

    constructor (info_branch_amount: Int, info_leaf_amount: Int) : this(info_branch_amount, info_leaf_amount, "Undefined")

    constructor (info_branch_amount: Int, info_leaf_amount: Int, info_berry_type: String, info_berry_amount: Int) : this(info_branch_amount, info_leaf_amount, info_berry_type) {
        this.amountOfBerries = info_berry_amount
    }

    override fun getLeavesPerBranchRatio(): Float {
        if (this.amountOfBranches == 0) {
            println("Error! There are no branches on this tree!")
            return 0.0F
        }
        var ratio: Float = this.amountOfLeaves * 1.0F / this.amountOfBranches
        println("The leaf/branch ratio is ${ratio}")
        return ratio
    }
    override fun setAmountOfLeavesViaRatio(ratio: Float) {
        if (this.amountOfBranches == 0) {
            println("Operation is redundant since there are no branches on this tree.")
        } else {
            this.amountOfLeaves = (this.amountOfBranches * ratio).toInt()
            println("Set the new amount of leaves to ${this.amountOfLeaves}")
        }
    }

    fun getBerriesPerBranchRatio(): Float {
        if (this.amountOfBranches == 0) {
            println("Error! There are no branches on this tree!")
            return 0.0F
        }
        var ratio: Float = this.amountOfBerries * 1.0F / this.amountOfBranches
        println("The berry/branch ratio is ${ratio}")
        return ratio
    }

    fun setAmountOfBerriesViaRatio(ratio: Float) {
        if (this.amountOfBranches == 0) {
            println("Operation is redundant since there are no branches on this tree.")
        } else {
            this.amountOfBerries = (this.amountOfBranches * ratio).toInt()
            println("Set the new amount of berries to ${this.amountOfBerries}")
        }
    }
}





fun main(args: Array<String>) {
    var localTree = Tree(10, 100)
    var ratio = localTree.getLeavesPerBranchRatio()
    println("The leaf/branch ratio is ${ratio}")
    localTree.setAmountOfLeavesViaRatio(5.0F)
    println("New amount of leaves is ${localTree.amountOfLeaves}")

    println("================================================")

    var localCherryTree = BerryTree(10, 100, "Cherry", 25)
    localCherryTree.getLeavesPerBranchRatio()
    localCherryTree.setAmountOfLeavesViaRatio(5.0F)
    localCherryTree.getBerriesPerBranchRatio()
    localCherryTree.setAmountOfBerriesViaRatio(2.0F)
}