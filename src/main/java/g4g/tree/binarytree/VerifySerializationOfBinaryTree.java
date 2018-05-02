package g4g.tree.binarytree;

public class VerifySerializationOfBinaryTree {

    private static final String DELIMITER = ",";
    private static final String NULL = "#";


    public static void main(String[] args) {

        VerifySerializationOfBinaryTree verify = new VerifySerializationOfBinaryTree();

        String preOrderRightAnswer = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String preOrderWrongAnswer = "#,1,#";

        boolean answer1 = verify.isValidPreorderSerialization(preOrderRightAnswer);
        System.out.println("PreOrder-: except: true, actually: "+answer1);
        boolean answer2 = verify.isValidPreorderSerialization(preOrderWrongAnswer);
        System.out.println("PreOrder-: except: false, actually: "+answer2);


    }


    // degreeDiff = inDegree - outDegree
    private boolean isValidPreorderSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        int degreeDiff = -1;
        String[] nodes = preorder.split(DELIMITER);
        for (String node : nodes) {
            if (++degreeDiff > 0) {
                return false;
            }
            if (!node.equals(NULL)) {
                degreeDiff -= 2;
            }
        }
        return degreeDiff == 0;
    }



}

