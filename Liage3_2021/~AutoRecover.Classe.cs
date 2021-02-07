using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.models
{
    public class Classe
    {
        //Attributs
        private int id;
        private string libelle;
        private int nbreEtudiant;


        //Constructeurs
        //Surcharges
        //Par Défaut
        public Classe()
        {

        }
        //Insertion

        public Classe(string libelle, int nbreEtudiant)
        {
            this.Libelle = libelle;
            this.NbreEtudiant = nbreEtudiant;
        }

        public Classe(int id)
        {
            this.id = id;
        }


        //Selection
        public Classe(int id, string libelle, int nbreEtudiant)
        {
            this.Id = id;
            this.Libelle = libelle;
            this.NbreEtudiant = nbreEtudiant;
        }

        //Get & Set
        public int Id { get => id; set => id = value; }
        public string Libelle { get => libelle; set => libelle = value; }
        public int NbreEtudiant { get => nbreEtudiant; set => nbreEtudiant = value; }

        //ToString()
        public override string ToString()
        {
            return libelle;
        }

    }
}
