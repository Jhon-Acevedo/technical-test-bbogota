import {Component, OnInit} from '@angular/core';
import {IApiResponseUser} from "../../../core/models/IApiResponseUser";
import {NgIf} from "@angular/common";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-user-details',
  standalone: true,
  imports: [
    NgIf,
    FormsModule
  ],
  templateUrl: './user-details.component.html',
  styleUrl: './user-details.component.css'
})
export class UserDetailsComponent implements OnInit{

  user? : IApiResponseUser;

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem('user') || '{}');
  }

}
