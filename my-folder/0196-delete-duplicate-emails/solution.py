import pandas as pd

def delete_duplicate_emails(person: pd.DataFrame) -> None:
    person.drop(
    person.index.difference(person.groupby("email")["id"].idxmin()),
    inplace=True
    )
    
