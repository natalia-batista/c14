cd C14_AtividadeAeroportos
sudo apt-get install mailutils
echo "Sending email after pipeline completion" | mail -s "Pipeline Works!" $EMAIL_PIPELINE