#Regular Expression!!!!

#exprement : input e-mail
#->check if it is the valid e-mail
#->if not, return to the imput
#-> if yes, add it to the list, and parse the email below
#list 'emails' => contain the full email address
#list 'ids' => contain the id part of email address
#list 'services' => contain the mail service providers.

#declare the variables
email       :str
emails      :list[str]
ids         :list[str]
services    :list[str]

while True:
    email = input("Type the email address:")
    