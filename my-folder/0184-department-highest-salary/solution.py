import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    df = employee.merge(department, left_on='departmentId', right_on='id')
    
    df = df.loc[
        df.groupby('departmentId')['salary'].transform('max') == df['salary']
    ]

    return df[['name_y', 'name_x', 'salary']].rename(columns={ 
        'name_y': 'Department',  # department name column
        'name_x': 'Employee',    # employee name column
        'salary': 'Salary'       # salary column
    })
