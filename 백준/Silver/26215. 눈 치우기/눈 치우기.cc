#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	
	vector<int> snows;
	for (int i = 0; i < n; ++i) {
		int input;
		cin >> input;
		snows.push_back(input);
	}

	if (n == 1) {
		if (snows[0] > 1440) cout << -1;
		else cout << snows[0];
		return 0;
	}

	int time = 0;
	while (true) {
		sort(snows.begin(), snows.end());
		
		//모든 눈을 치운 경우
		if (snows[n - 1] == 0) break;

		snows[n - 1]--;
		if(snows[n - 2] != 0) snows[n - 2]--;
		time++;

		if (time > 1440) {
			cout << -1;
			return 0;
		}
	}
	
	cout << time;
	return 0;
}