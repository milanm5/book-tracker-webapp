import { Component, inject, Injectable } from '@angular/core';
import { routes } from '../../app.routes';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-header',
  imports: [FormsModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
@Injectable({providedIn: "root"})
export class HeaderComponent {

  private router = inject(Router);
  public query = "";

  public SearchQuery(query: string) {
    this.router.navigate(["/searchResult"], {
      queryParams: {q: this.query}
    });
  }

}
