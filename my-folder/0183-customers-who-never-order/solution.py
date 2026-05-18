import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    df = customers.merge(
        orders, 
        how='left', 
        left_on='id', 
        right_on='customerId'
    )

    df = df[df['customerId'].isna()]
    
    df = df.rename(columns={"name" : "Customers"})

    return df[["Customers"]]
