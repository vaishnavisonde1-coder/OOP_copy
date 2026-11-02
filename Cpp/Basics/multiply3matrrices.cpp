#include <iostream>
using namespace std;

int main() {
    int A[10][10], B[10][10], C[10][10];
    int AB[10][10] = {0}, ABC[10][10] = {0};

    int m, n, p, q;

    cin >> m >> n;   
    for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){
            cin >> A[i][j];}}

    cin >> n >> p;   
    for (int i = 0; i < n; i++){
        for (int j = 0; j < p; j++){
            cin >> B[i][j];}}

    cin >> p >> q;  
    for (int i = 0; i < p; i++){
        for (int j = 0; j < q; j++){
            cin >> C[i][j];}}
            
    
    return 0;
}