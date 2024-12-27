
public class Main {
    public static void main(String[] args) {
        node<Integer> node9 = new node<>(7, null);
        node<Integer> node8 = new node<>(11, node9);
        node<Integer> node7 = new node<>(6, node8);
        node<Integer> node6 = new node<>(4, node7);
        node<Integer> node5 = new node<>(8, node6);
        node<Integer> node4 = new node<>(7, node5);
        node<Integer> node3 = new node<>(5, node4);
        node<Integer> node2 = new node<>(20, node3);
        node<Integer> root = new node<>(10, node2);
        print(root);
        print(split(root));
        print(root);
    }
    public static void print(node<Integer> root) {
        node current = root;
        while (current != null) {
            System.out.print(current.getData() + ", ");
            current = current.getNext();
        }
        System.out.println();
    }

    //ADD
    public static void addFirst(node<Integer> root, node<Integer> toAdd) {
        toAdd.setNext(root);
        root = toAdd;
    }
    public static void addLast(node<Integer> root, node<Integer> toAdd) {
        node<Integer> current = root;
        if (root == null) {
            root = toAdd;
            return;
        }
        while (current.getNext() != null) current = current.getNext();
        current.setNext(toAdd);
    }
    public static void addAtPosition(node<Integer> root, node<Integer> toAdd, int position) {
        if (position == 1) {
            toAdd.setNext(root);
            root = toAdd;
            return;
        }
        node<Integer> current = root;
        for (int i = 1; i < position - 1; i++) current = current.getNext();
        toAdd.setNext(current.getNext());
        current.setNext(toAdd);
    }

    //REMOVE
    public static void removeFirst(node<Integer> root) {
        root = root.getNext();
        print(root);
    }
    public static void removeLast(node<Integer> root) {
        if (root.getNext() == null) {
            root = null;
            return;
        }
        node<Integer> current = root;
        while (current.getNext().getNext() != null) current = current.getNext();
        current.setNext(null);
        print(root);
    }
    public static void removeAtPosition(node<Integer> root, int position) {
        if (position == 1) {
            root = root.getNext();
            print(root);
            return;
        }
        node<Integer> current = root;
        for (int i = 1; i < position - 1; i++) current = current.getNext();
        current.setNext(current.getNext().getNext());
        print(root);
    }

    public static void buildFreqList(node<Integer> root) {
        node<Integer> current = root;
        while (current != null) {
            node<Integer> runner = current;
            int count = 1;
            while (runner.getNext() != null) {
                if (runner.getNext().getData() == current.getData()) {
                    count++;
                    runner.setNext(runner.getNext().getNext());
                } else runner = runner.getNext();
            }
            node<Integer> ans = new node<>(count);
            ans.setNext(current.getNext());
            current.setNext(ans);
            current = ans.getNext();
        }
        print(root);
        System.out.println();
        print(root);
    }
    public static int mostPopularNumber(node<Integer> root) {
        node<Integer> current = root;
        int max = 0, count = 0, ans = 0;
        while (current != null) {
            if (count % 2 == 0 && current.getNext().getData() > max) {
                max = current.getNext().getData();
                ans = current.getData();
            }
            count++;
            current = current.getNext();
        }
        return ans;
    }

    public static void first(node<Integer> root) {
        node<Integer> current = root;
        while (current != null) {
            node duplicate = new node(current.getData());
            duplicate.setNext(current.getNext());
            current.setNext(duplicate);
            current = duplicate.getNext();
        }
        print(root);
    }
    public static void second(node<Integer> root) {
        node<Integer> current = root;
        int count = 0;
        while (current.getNext() != null) {
            count++;
            current = current.getNext();
        }
        node<Integer> current2 = root;
        for (int i = 0; i <= count; i++) {
            current.setNext(new node<>(current2.getData()));
            current2 = current2.getNext();
            current = current.getNext();
        }
        print(root);
    }

    public static node<Double> averageList(node<Integer> root) {
        node<Double> avg = null;
        node<Double> avgRunner = null;
        node<Integer> current = root;
        while (current != null) {
            double currentAvg = 0, count = 0;
            while (current.getData() != -1) {
                count++;
                currentAvg += current.getData();
                current = current.getNext();
            }
            currentAvg /= count;
            if (avg == null) {
                avg = new node<>(currentAvg);
                avgRunner = avg;
                avgRunner.setNext(avg);
            } else avgRunner.setNext(new node<>(currentAvg));
            avgRunner = avgRunner.getNext();
            current = current.getNext();
        }
        return avg;
    }

    public static void order(binNode<Integer> root) {
        binNode<Integer> current = root;
        binNode<Integer> update = root;
        while (current != null && update != null) {
            while (update != null && update.getData() % 2 == 0)
                update = update.getNext();
            if (current.getData() % 2 != 0) {
                int temp = update.getData();
                update.setData(current.getData());
                current.setData(temp);
                current = current.getNext();
            } else
                current = current.getNext();
        }
    }

    public static node<Integer> split(node<Integer> root){
        node<Integer> newRoot = null; node<Integer> newRootRunner = null;
        node<Integer> prev = null; node<Integer> runner = root;

        boolean isEven = root.getData()%2 == 0;

        while (runner != null){
            if ((runner.getData()%2 != 0) == isEven){
                if (newRoot == null){
                    newRoot = runner;
                    newRootRunner = runner;
                } else {
                    newRootRunner.setNext(runner);
                    newRootRunner = newRootRunner.getNext();
                }
                if (prev != null) prev.setNext(runner.getNext());
                else root = runner.getNext();
            } else prev = runner;
            runner = runner.getNext();
        }
        if (newRootRunner != null) newRootRunner.setNext(null);
        return newRoot;
    }
}
