package com.min.lib;

public class MyClass {


    public static void main(String[] args) {

        Solution s = new Solution();
        int result = s.solution(map);
    }

    public static int map[][] = {{1,0,1,1}, {0,0,1,1}, {1,1,0,1}, {1,1,0,0}};
}


class Solution{

    private static int U = -1;
    private static int E = 1;
    private static int S = 0;


    int maxX = 0;
    int maxY = 0;
    int totalCount = 0;
    int[][] marker;
    int[][] map;
    int checkIndex = 0;

    public int solution(int[][] map){
        this.marker = map.clone();
        this.map = map;


        Point point = new Point(0, 0);

        maxX = map[0].length;
        maxY = map.length;
        totalCount = maxX * maxY;

        int answer = 0;

        while(checkIndex < totalCount) {

            point = new Point(checkIndex % maxX, checkIndex / maxX);

            checkIndex++;

                if (map[point.y][point.x] == 0) {
                    continue;
                }

                answer += searchAround(point);
        }

        return answer;
    }

    public int searchAround(Point point){

        int result = 0;

        if (marker[point.y][point.x] == U) {
            return 0;
        }

        marker[point.y][point.x] = U;

        //left-side check
        int add = searchLeft(point);
        result += add;

        //right-side check
        add =  searchRight(point);
        result += add;

        //bottom-side check
        add = searchBottom(point);
        result += add;

        //top-side check
        if ((checkIndex != 0 && checkIndex / maxX == 0) || marker[point.y][point.x] != E) {
            add = searchTop(point);
            result += add;
        }

        return result;
    }

    public int searchLeft(Point point){
        int result = 0;

        //left-side check
        int able = point.left().isSearchable();
        //right-side check
        if(able >= 0) {
            return able;
        }

        return searchAround(point.left());
    }

    public int searchRight(Point point){
        int result = 0;


        int able = point.right().isSearchable();
        //right-side check
        if(able >= 0) {
            return able;
        }

        return searchAround(point.right());
    }

    public int searchBottom(Point point){
        int result = 0;

        //bottom-side check
        int able = point.bottom().isSearchable();
        //right-side check
        if(able >= 0) {
            return able;
        }

        return searchAround(point.bottom());
    }

    public int searchTop(Point point){
        int result = 0;

        //bottom-side check
        int able = point.top().isSearchable();
        //right-side check
        if(able >= 0) {
            return able;
        }

        return searchAround(point.top());
    }

    class Point {
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        int x = 0;
        int y = 0;

        public Point top() {
            return new Point(x, y-1);
        }

        public Point left() {
            return new Point(x-1, y);
        }

        public Point right() {
            return new Point(x+1, y);
        }

        public Point bottom() {
            return new Point(x, y+1);
        }


        public int isSearchable(){
            if (x < 0 || x >= maxX) {
                return 1;
            }

            if (y < 0 || y >= maxY) {
                return 1;
            }

            if (map[y][x] == S) {
                return 1;
            }

            if (marker[y][x] == U) {
                return 0;
            }

            return -1;
        }
    }
}

//r x c 크기 지도



