#include <iostream>
#include "Account.h"
using namespace std;

//public methods
Account::Account() {

}
Account::Account(string n, long t, double b) {

}
void Account::SetName(string s) {

}
void Account::SetTaxID(long l) {

}
void Account::Setbalance(double d) {

}
string Account::GetName() {

}
long Account::GetTaxID() {

}
double Account::Getbalance() {

}
void Account::MakeDeposit(double amount) {

}
void Account::display() {

}

//protected methods
double Account::last10withdraws[10] {

}
double Account::last10deposits[10] {

}
int Account::numdeposits {

}
int Account::numwithdraws {

}