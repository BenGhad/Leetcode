import pandas as pd

def calculate_special_bonus(employees: pd.DataFrame) -> pd.DataFrame:
    employees.loc[
        employees['name'].str[0].eq("M") |
        employees['employee_id'].mod(2).eq(0),
        'salary'
    ] = 0
    
    employees = employees.rename(columns={'salary':'bonus'})

    return employees[['employee_id', 'bonus']].sort_values(by='employee_id')
