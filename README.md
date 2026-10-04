# Assignment 3: Bridge Pattern

Orynbassarov Yerassyl
Group: SE-2530
Topic: C (Reports)
Repository: https://github.com/yerraxd/bridge_asn3
Base commit: 8593c027b424af59a6ef9ecb6ff7b1f879b7724c

## Role map

| Role | Class | Path |
|---|---|---|
| Abstraction | Report | src/reports/Report.java |
| A1 | AttendanceReport | src/reports/AttendanceReport.java |
| A2 | GradeReport | src/reports/GradeReport.java |
| Implementor | Formatter | src/reports/Formatter.java |
| I1 | TextFormatter | src/reports/TextFormatter.java |
| I2 | HtmlFormatter | src/reports/HtmlFormatter.java |
| I3 | MarkdownFormatter | src/reports/MarkdownFormatter.java |
| Client | Main | src/Main.java |

## Where to look
- Bridge field: `formatter` in `Report.java`
- `execute()`: `Report.java`
- `setImplementation(...)`: `Report.java`
- T5 check: `runtimeSwitchCheck()` in `Main.java`

## Run
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo

## Expected results
T1 PASS | AttendanceReport + TextFormatter | result=ATTENDANCE REPORT | attended=3 | total=4 | rate=75%
T2 PASS | AttendanceReport + HtmlFormatter | result=<html><body><h1>Attendance Report</h1><p>attended: 3</p><p>total: 4</p><p>rate: 75%</p></body></html>
T3 PASS | GradeReport + TextFormatter | result=GRADE REPORT | count=3 | average=80
T4 PASS | GradeReport + HtmlFormatter | result=<html><body><h1>Grade Report</h1><p>count: 3</p><p>average: 80</p></body></html>
T5 PASS | sameObject=true | stateUnchanged=true
T6 PASS | AttendanceReport + MarkdownFormatter | result=# Attendance Report\n- attended: 3\n- total: 4\n- rate: 75%
T7 PASS | GradeReport + MarkdownFormatter | result=# Grade Report\n- count: 3\n- average: 80
SUMMARY: 7/7 PASS
