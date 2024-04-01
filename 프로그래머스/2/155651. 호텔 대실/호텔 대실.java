import java.util.*;

class Solution {
    class Book{
        public Book(int start_time, int end_time) {
            this.start_time = start_time;
            this.end_time = end_time;
        }

        int start_time,end_time;
    }

    List<Book> bookList=new ArrayList<>();
    int toMinute(String time){
        StringTokenizer stk=new StringTokenizer(time,":");
        int hour=Integer.parseInt(stk.nextToken());
        int minute=Integer.parseInt(stk.nextToken());
        return hour*60+minute;
    }

    public int solution(String[][] book_times) {
        for(String[] book_time:book_times){
            int start_time=toMinute(book_time[0]);
            int end_time=toMinute(book_time[1]);

            bookList.add(new Book(start_time,end_time));
        }
        // 시작 시간대로 정렬
        Collections.sort(bookList,(o1,o2)->{
            if(o1.start_time==o2.start_time) return o1.end_time-o2.end_time;
            else return o1.start_time-o2.start_time;
        });

        // 리스트를 방문하며 몇개가 필요할지 체크
        List<Integer> endTimeList=new ArrayList<>();

        for(Book book:bookList){
            boolean isOk=false;
            // end_time 기준으로 정렬
            Collections.sort(endTimeList);
            for(int i=0;i<endTimeList.size();i++){
                // 정리시간 10분
                int endTime=endTimeList.get(i)+10;
                // check
                if(book.start_time>=endTime) {
                    // 예약 시간 넣고 업데이트
                    endTimeList.set(i,book.end_time);
                    isOk=true;
                    break;
                }
            }
            // 아무 방도 넣지 못하면 새로운 방 추가
            if(!isOk) endTimeList.add(book.end_time);
        }

        return endTimeList.size();
    }
}