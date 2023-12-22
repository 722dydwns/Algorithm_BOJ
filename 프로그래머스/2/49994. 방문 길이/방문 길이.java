import java.util.*;

class Point{
    int curx, cury, nx, ny;
    Point(int curx, int cury, int nx, int ny){
        this.curx = curx;
        this.cury = cury;
        this.nx = nx;
        this.ny = ny;
    }
    
    @Override 
    public boolean equals(Object obj){
        if(obj instanceof Point){
            Point o = (Point) obj;
            return (this.curx == o.curx && this.cury == o.cury && this.nx == o.nx && this.ny == o.ny) || (this.curx == o.nx && this.cury == o.ny && this.nx == o.curx && this.ny == o.cury);
        }
        return false;
    } 
    
    @Override
    public int hashCode(){
        return Objects.hash(Math.min(curx, nx), Math.min(cury, ny), Math.max(curx, nx), Math.max(cury, ny));
    }
}
class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0 };
    
    public int solution(String dirs) {
        int answer = 0;
        int curX = 0, curY = 0;
        
        Map<Point, Integer> map = new HashMap<>();
        
        for(char x : dirs.toCharArray()){
            int dirIdx = 0;
            
            if(x == 'U'){
                dirIdx = 0;
            }else if(x == 'D'){
                dirIdx = 1;
            }else if(x == 'L'){
                dirIdx = 2;
            }else if(x == 'R'){
                dirIdx = 3;
            }
            
            int nx = curX + dx[dirIdx];
            int ny = curY + dy[dirIdx];
            
            if(nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5) {
                Point path = new Point(curX, curY, nx, ny);
                map.put(path, map.getOrDefault(path, 0) + 1);
                
                curX = nx;
                curY = ny;
            }
        }
        
        System.out.println(map.size());
        
        return map.size();
    }
}