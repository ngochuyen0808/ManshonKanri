package Manshon;
import java.util.Scanner;

public class Manshon {
	static Room[]room = new Room[15];
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<3;j++){
				int room_num = (i+1)*100+j+1;
				if(j==2) {
					room[i*3+j]=new Room(room_num,2);
				}else {
					room[i*3+j]=new Room(room_num,1);
				}
			
				
			}
		}
		disp();
		int count=0;
		int room_x;
		int room_y;
		
		do {
			System.out.print("どうする？(0:入る 1:出る))=");
			int room_in_out = scanner.nextInt();
			
			if(room_in_out<0||room_in_out>1) {
				System.out.println("入力できるのは (0:入る 1:出る)のみです");
				
				continue;
			}
			System.out.print("部屋No:");
			int room_no = scanner.nextInt();
			room_y=(room_no/100)-1;
			room_x = (room_no%100)-1;
			if(room_y<0 || room_y>4 || room_x <0 || room_x>2 ) {
			
				System.out.println("入力された部屋Noがありません。もう一度入力してください");
				continue;
			}
			if(room_in_out == 0) {
				System.out.print("人数:");
				
				int p_cnt = scanner.nextInt();
				if(p_cnt>0&&p_cnt<=room[room_y*3+room_x].getPeople_s_cnt()) {
					
				}else {
					System.out.println("その人数では入居出来ません。もう一度入力してください");
					continue;
				}
				System.out.print("名前:");
				room[room_y*3+room_x].setName(scanner.next());
				if(room[room_y*3+room_x].getRoom_status()==0) {
					room[room_y*3+room_x].setRoom_status(1);
					System.out.println(room[room_y*3+room_x].getName()+"さん入りました。");
					
				}else {
				System.out.println("入居済みです。");
				continue;
				}
			}else {
				if(room[room_y*3+room_x].getRoom_status()==1) {
					room[room_y*3+room_x].setRoom_status(0);
					System.out.println(room[room_y*3+room_x].getName()+"さん出ました。");
				}else {
					System.out.println("空室");
					continue;
				}
			}
			disp();
			count++;
		}while(count<15);
	}
static void disp(){
	
	
		
		for(int i=4;i>=0;i--){
			for(int j=0;j<3;j++) {
				if(room[i*3+j].getRoom_status() == 0) {
					System.out.print("□");
				}else if(room[i*3+j].getRoom_status() == 1) {
					System.out.print("■");
				}
			}System.out.println("");
		}
	}

}
class Room{
	int room_status;
	int room_number;
	String name;
	int people_s_cnt;
	int people_cnt;
	
	Room(int room_num,int peo_s_c){
		room_status=0;
		room_number=room_num;
		people_s_cnt = peo_s_c;
	}
	
	void setRoom_status(int status) {
		room_status=status;
	}
	int getRoom_status(){
		return room_status;
	}
	int setRoom_status() {
		return room_status;
	}
	void setRoom_number(int number) {
		room_number = number;
	}
	int getRoom_number() {
		return room_number;
	}
	int setRoom_number() {
		return room_number;
	}
	void setName(String name_s) {
		name = name_s;
	}
	String getName() {
		return name;
	}
	void setPeople_cnt(int pc) {
		people_cnt = pc;
	}
	int getPeople_cnt() {
		return people_cnt;
	}
	int setPeople_cnt() {
		return people_cnt;
	}
	void setPeople_s_cnt(int psc) {
		people_s_cnt = psc;
	}
	int getPeople_s_cnt() {
		return people_s_cnt;
	}
	int setPeople_s_cnt() {
		return people_s_cnt;
	}
	
}
