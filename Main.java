public class Main{
        public static void printWorld(int[][] world, int pinguRow, int pinguColumn) {
            for (int i = 0; i < world.length ; i++) {
                for (int j = 0; j < world[i].length; j++) {
                    if(world[i][j] == 0)
                        System.out.print("L");
                    else if(world[i][j] == 1)
                        System.out.print("I");
                    else if(world[i][j] == 2)
                        System.out.print("W");
                    else if(world[i][j] == 3)
                        System.out.print("S");
                    else if(world[i][j] == 4)
                        System.out.print("F");

                    if (i == pinguRow && j == pinguColumn)
                        System.out.print("(P)");
                    if (j < world[i].length - 1)
                        System.out.print("\t");
                }
                System.out.print("\n");
            }
        }
        public static boolean isFishReachable(int[][] world, int pinguRow, int pinguColumn){
            if(pinguRow < 0)
                return false;
            if(pinguRow >= world.length)
                return false;
            if(pinguColumn < 0)
                return false;
            if(pinguColumn >= world[0].length)
                return false;

            boolean result = false;
            int  pos = world[pinguRow][pinguColumn];
            world[pinguRow][pinguColumn] = 3;
            if(pos == 0){
                //land emot qvemot marjvniv marcxniv

                result = isFishReachable(world, pinguRow + 1, pinguColumn);
                if(!result)
                    result = isFishReachable(world, pinguRow - 1, pinguColumn);
                if(!result)
                    result = isFishReachable(world, pinguRow, pinguColumn + 1);
                if(!result)
                    result = isFishReachable(world, pinguRow, pinguColumn - 1);

            }else if(pos == 1){
                //ice diagonals by 1 step
                result = isFishReachable(world, pinguRow + 1, pinguColumn + 1);
                if(!result)
                    result = isFishReachable(world, pinguRow - 1, pinguColumn + 1);
                if(!result)
                    result = isFishReachable(world, pinguRow + 1, pinguColumn - 1);
                if(!result)
                    result = isFishReachable(world, pinguRow - 1, pinguColumn - 1);
            }else if(pos == 2) {
                //water diagonals by 3 step
                result = isFishReachable(world, pinguRow + 3, pinguColumn + 3);
                if(!result)
                    result = isFishReachable(world, pinguRow - 3, pinguColumn + 3);
                if(!result)
                    result = isFishReachable(world, pinguRow + 3, pinguColumn - 3);
                if(!result)
                    result = isFishReachable(world, pinguRow - 3, pinguColumn - 3);
            }else if(pos == 3){
                result = false;
            }else if(pos == 4){
                result = true;
            }
            world[pinguRow][pinguColumn] = pos;
            return result;
        }
        /**
         * returns the example world 1.
         * @return An example world
         */
        public static int[][] generateExampleWorldOne(){
            return new int[][] {{2,3,3,3,3,3}, {3,0,3,3,4,3}, {3,3,3,3,3,1}, {3,3,3,0,1,3}, {3,3,3,3,3,3}};
        }
        /**
         * returns the example world 1.
         * @return An example world
         */
        public static int[][] generateExampleWorldTwo(){
            return new int[][] {{0,0,0,2}, {0,0,0,1}, {0,1,3,4}, {3,4,3,3}};
        }

        public static void main(String[] args){
            int pinguRow = 0;
            int pinguColumn = 0;
            int[][] world = generateExampleWorldTwo();
            int[][] world1 = generateExampleWorldOne();
            printWorld(world, pinguRow, pinguColumn);
            System.out.println(""+isFishReachable(world, pinguRow, pinguColumn));
            printWorld(world1, pinguRow, pinguColumn);
            System.out.println(""+isFishReachable(world1, pinguRow, pinguColumn));
        }
    }

