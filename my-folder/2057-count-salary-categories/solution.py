import pandas as pd

def count_salary_categories(accounts: pd.DataFrame) -> pd.DataFrame:
    labels = ['Low Salary', 'Average Salary', 'High Salary']
    
    return pd.cut(
        accounts['income'], 
        bins=[-1, 20000-1, 50000, float('inf')],
        labels=labels,
        ).value_counts().reset_index().rename(columns={'income':'category','count':'accounts_count'})
