import { Component, OnInit } from "@angular/core";
import { Star } from "../../models/star";

import { StarService } from "../../services/star.service";
import { AstronomersService } from "../../services/astronomer.service";
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";

import { CsrfService } from "../../services/csrf.service";
import {Astronomers} from "../../models/astronomer";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
})
export class HomeComponent implements OnInit {
  public stars!: Star[];
  public astronomers!: Astronomers[];
  public starClasses: string[] = [];

  showModal: boolean = false;
  formTitle: string = "";
  star: Star = {
    id: BigInt(0),
    name: "",
    dec: "",
    ra: "",
    class: "",
    astronomer: "",
  };
  astronomer: Astronomers = {
    name: "",
  };
  submitButtonText: string = "";

  constructor(
    private modalService: NgbModal,
    private starService: StarService,
    private astronomersService: AstronomersService,
    private csrfService: CsrfService
  ) {}

  ngOnInit(): void {
    this.getStars();
    this.getAstronomers();
    this.getCsrfToken();
  }

  getStars(): void {
    this.starService.getStars().subscribe((stars) => (this.stars = stars));
  }

  getAstronomers(): void {
    this.astronomersService
      .getAstronomers()
      .subscribe((astronomers) => (this.astronomers = astronomers));
  }

  getCsrfToken(): void {
    this.csrfService.getCsrfToken().subscribe((token) => {
      console.log(token);
    });
  }

  addStar(): void {
    this.showModal = true;
    this.formTitle = "Добавить звезду";
    this.submitButtonText = "Добавить";
    this.star = {
      id: BigInt(0),
      name: "",
      dec: "",
      ra: "",
      class: "",
      astronomer: "",
    };
  }

  editStar(star: Star): void {
    this.showModal = true;
    this.formTitle = "Изменить звезду";
    this.submitButtonText = "Сохранить";
    this.star = { ...star };
  }

  saveStar(): void {
    this.starService.addStar(this.star).subscribe(() => {
      this.getStars();
      this.showModal = false;
    });
    this.getStars();
    this.showModal = false;
  }

  deleteStar(id: bigint): void {
    this.starService.deleteStar(id).subscribe(() => {
      this.getStars();
    });
    this.getStars();
  }
}
