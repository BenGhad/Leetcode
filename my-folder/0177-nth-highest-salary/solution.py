import pandas as pd

def nth_highest_salary(employee: pd.DataFrame, N: int) -> pd.DataFrame:
    if N <= 0:
        return pd.DataFrame(data={
        'getNthHighestSalary(' + str(N) + ')' : [None]
    })
 
    salaries = employee['salary'].drop_duplicates().sort_values(ascending=False)

    return pd.DataFrame(data={
        'getNthHighestSalary(' + str(N) + ')' : [salaries.iloc[N-1] if len(salaries) >= N  else None]
    })

